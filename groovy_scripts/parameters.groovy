pipeline { 
    agent any
    parameters {
        string(name: 'VERSION', defaultValue: '', description: 'version to deploy on prod')
        choice(name: 'VERSION', choices: ['1.0.0', '1.0.1', '1.0.2'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    } 

    stages {   
        stage("build") {
            steps {
                echo 'building the application'
                //sh 'mvn package'
            }
        }    
    }    
}

parametize your build:
- for when you have some external configurations to provide to your build to change some behavior.
     - eg. when you have an application that deploys to a staging server and you want to select the version of the application you want to deploy.
- provide the type of the parameter:
    - string       (name, defaultValue, description)
    - choice       (name, choices, description)
    - booleanParam (name, defaultValue, description) eg.  for when you want to skip some stage of the build

pipeline { 
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.0.0', '1.0.1', '1.0.2'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    } 

    stages {   
        stage("build") {
            steps {
                echo 'building the application'
                //sh 'mvn package'
            }
        } 

        stage("test") {
            when {
                expression {
                  params.executeTests == true 
                }
            }
            steps {
                echo 'testing the application'
            }
        }

        stage("deploy") {
            steps{
                 echo 'deploying the application'
                 echo "deploying version ${params.VERSION}"                
            }
        }   
    }    
}

if executeTests is true can expressed simply as params.executeTests or as params.executeTests == true