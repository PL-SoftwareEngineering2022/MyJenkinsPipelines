pipeline { 
    agent any 
    environment{ //any variables defined here will be available to the rest of the pipeline. eg. a version.
        NEW_VERSION = '1.3.0'
        SERVER_CREDENTIALS = credentials()// can be fined globally or at the stage the credentials are going to be used.
    }

    stages { 
        stage("build") {
            steps {
                echo 'building the application'
                echo "building version ${NEW_VERSION}"
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
                 echo "deploying with ${SERVER_CREDENTIALS}"
            }
        }
    }

    post { 
        always{
            
        }
    }
}

1. Please note that if you use an enviromnmental variable in groovy, you need to use double quotes, not single quotes: 
- However, you can use single quotes if it is just a simple string. 
    echo 'building version ${NEW_VERSION}'
    echo "building version ${NEW_VERSION}"

2. enviromnmental variables can also be used to set credentials in Jenkins.
- define credentials in Jenkins GUI
- "credentials("credentialId")" binds the credentials defined in Jenkins to your enviromnmental variable
- for that, you need "Credentials Binding" Plugin. As a parameter it takes the ID reference of the credentials in Jenkins

OR:

pipeline { 
    agent any 
    stages { 

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
                withCredentials([
                    usernamePassword()
                ]) {

                }
            }
        }
    }    
}