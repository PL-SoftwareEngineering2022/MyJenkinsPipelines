pipeline { // must be top level;

    agent any //where to execute

    stages { //where the "work" happens

        stage("build") {
            steps {
                echo 'building the application'
                //sh 'mvn package'
            }
        }

        stage("test") {
            steps {
                echo 'testing the application'
            }
        }

        stage("deploy") {
            steps{
                 echo 'deploying the application'
                
            }
        }
    }

    post { //executes some logic after aall stages executed
        always{
            // will be executed regardless of build failure of success
        }
    }
}

/*
post conditions:
always- gives directive of what needs to happens regardless of build failure or success
success- what needs to happen if the build is successful
failure- what needs to happens after a failure 
*/