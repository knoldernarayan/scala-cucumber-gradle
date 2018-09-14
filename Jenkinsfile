node('master') {
 	// Clean workspace before doing anything
    deleteDir()

    try {

        stage ('Build') {
        	sh "echo 'shell scripts to build project...'"
        	sh "echo 'shell scripts to build project...'"
        }
        stage ('Unit test'){
        sh """
           cd scala-cucumber-gradle
           ./gradlew test
           """
        }
        stage ("User Acceptance test"){
         sh """
              cd /home/narayan/projects/scala-gradle-cucumber
              ./gradlew test
              """
        }
      	stage ('Deploy') {
            sh "echo 'shell scripts to deploy to server...'"
      	}
    } catch (err) {
        currentBuild.result = 'FAILED'
        throw err
    }
}
