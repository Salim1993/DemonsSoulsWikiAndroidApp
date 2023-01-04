//Code from tutorial: https://nimblehq.co/blog/jenkins-pipeline-for-mobile-testing

pipeline {
  agent any

  stages {                                      
    stage('Unit Test') {
          steps {
            // Execute your Unit Test
            bat './gradlew testDebugUnitTest'
          }
    }

    stage('UI Testing') {
      steps {
        script {                                                          
          if (currentBuild.result == null         
              || currentBuild.result == 'SUCCESS') {  
          // Start your emulator, testing tools
          bat 'C:/Users/Salim/AppData/Local/Android/Sdk/emulator/emulator.exe -avd Pixel_3a_API_33_x86_64'
     
          // You're set to go, now execute your UI test
          bat './gradlew connectedDebugAndroidTest'  
          }
        }
      }
    }

}

  post {                                          
    always {
      archiveArtifacts(allowEmptyArchive: true, artifacts: 'app/build/outputs/apk/production/release/*.apk')

      // And kill the emulator?
      bat 'C:/Users/Salim/AppData/Local/Android/Sdk/platform-tools/adb.exe emu kill'
    }
  }
}
