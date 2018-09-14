node {
   // Clean workspace before doing anything
    deleteDir()
 try {
    def server
    def buildInfo
    def rtGradle
    
    stage ('Clone') {
        git url: 'https://github.com/knoldernarayan/scala-cucumber-gradle.git'
    }
 
    stage ('Artifactory configuration') {
        // Obtain an Artifactory server instance, defined in Jenkins --> Manage:
        server = Artifactory.server SERVER_ID

        rtGradle = Artifactory.newGradleBuild()
        rtGradle.tool = GRADLE_TOOL // Tool name from Jenkins configuration
        rtGradle.deployer repo: 'libs-release-local', server: server
        rtGradle.resolver repo: 'libs-release', server: server
        rtGradle.deployer.deployArtifacts = false // Disable artifacts deployment during Gradle run
        
        buildInfo = Artifactory.newBuildInfo()
    }
 
    stage ('Test') {
        rtGradle.run rootDir: 'gradle-examples/gradle-example-ci-server/', buildFile: 'build.gradle', tasks: 'clean test'
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
