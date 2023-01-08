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

    stage('Setup ADB server') {
      steps {
        bat 'C:/Users/Salim/AppData/Local/Android/Sdk/platform-tools/adb.exe start-server'
      }
    }
    
    stage('UI Testing') {
        parallel {
            stage("Launch Emulator") {
              steps {
                script {                                                          
                  if (currentBuild.result == null || currentBuild.result == 'SUCCESS') {  
                    // Start your emulator, testing tools: 
                    // https://stackoverflow.com/questions/39566514/android-emulator-for-jenkins-pipeline
                    //bat 'C:/Users/Salim/AppData/Local/Android/Sdk/emulator/emulator.exe -avd Pixel_3a_API_33_x86_64 -no-snapshot-load -no-snapshot-save -no-window'
                    bat 'C:/Users/Salim/AppData/Local/Android/Sdk/emulator/emulator.exe -avd Pixel_3a_API_33_x86_64 -no-snapshot-load -no-snapshot-save'
                  }
                }
            }
          }
          stage("Run UI Test"){
            steps{
              script {                                                          
                if (currentBuild.result == null || currentBuild.result == 'SUCCESS') {  
                  //wait for device before running tests
                  timeout(time: 20, unit: 'SECONDS') {
                    bat 'C:/Users/Salim/AppData/Local/Android/Sdk/platform-tools/adb.exe wait-for-device'
                  }
            
                  // You're set to go, now execute your UI test
                  bat './gradlew connectedDebugAndroidTest'  
                }
              }
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
