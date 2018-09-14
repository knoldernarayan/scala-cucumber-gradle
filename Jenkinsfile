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
