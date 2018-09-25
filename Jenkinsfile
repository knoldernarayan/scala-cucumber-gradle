node {
   // Clean workspace before doing anything
    deleteDir()
 try {

    stage ('Clone') {
        git url: 'https://github.com/knoldernarayan/scala-cucumber-gradle.git'
    }

    stage ('Unit test'){
       sh './gradlew clean test'
    }
    stage ("User Acceptance test"){
         sh 'Running cucumber test'
         sh './gradlew clean store-runner'
    }
    stage ('Deploy') {
            sh "echo 'shell scripts to deploy to server...'"
    }

} catch (err) {
        currentBuild.result = 'FAILED'
        throw err
    }
}
