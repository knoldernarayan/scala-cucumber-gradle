node {
   // Clean workspace before doing anything
    deleteDir()
 try {

   def server = Artifactory.newServer url: SERVER_URL, credentialsId: CREDENTIALS
   def rtGradle = Artifactory.newGradleBuild()
   def buildInfo

    stage ('Clone') {
        git url: 'https://github.com/knoldernarayan/scala-cucumber-gradle.git'
    }

    stage ('Artifactory configuration') {
        rtGradle.tool = GRADLE_TOOL // Tool name from Jenkins configuration
        rtGradle.deployer repo: 'libs-release-local', server: server
        rtGradle.resolver repo: 'jcenter', server: server
    }

    stage ('Exec Gradle') {
        buildInfo = rtGradle.run rootDir: "gradle-examples/gradle-example-ci-server/", buildFile: 'build.gradle', tasks: 'clean artifactoryPublish'
    }

    stage ('Publish build info') {
        server.publishBuildInfo buildInfo
    }
    stage ('Unit test'){
       rtGradle.run rootDir: 'scala-cucumber-gradle/', buildFile: 'build.gradle', tasks: 'clean test'
    }
    stage ("User Acceptance test"){
         sh 'echo cucumber'
    }
    stage ('Deploy') {
            sh "echo 'shell scripts to deploy to server...'"
    }

} catch (err) {
        currentBuild.result = 'FAILED'
        throw err
    }
}
