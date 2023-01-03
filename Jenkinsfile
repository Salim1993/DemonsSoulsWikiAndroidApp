//Code from tutorial: https://nimblehq.co/blog/jenkins-pipeline-for-mobile-testing

pipeline {
  agent { 
    node { label 'android' }                     
  }

  stages {                                      
    stage('Unit Test') {
          steps {
            // Execute your Unit Test
            sh './gradlew testDebugUnitTest'
          }
    }

    stage('UI Testing') {
      steps {
        script {                                                          
          if (currentBuild.result == null         
              || currentBuild.result == 'SUCCESS') {  
          // Start your emulator, testing tools
          sh 'emulator @Pixel_3a_API_33_x86_64'
     
          // You're set to go, now execute your UI test
          sh './gradlew connectedDebugAndroidTest'  
          }
        }
      }
    }

}

  post {                                          
    always {
      archiveArtifacts(allowEmptyArchive: true, artifacts: 'app/build/outputs/apk/production/release/*.apk')

      // And kill the emulator?
      sh 'adb emu kill'
    }
  }
}
