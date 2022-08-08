def gv

pipeline { 
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.0.0', '1.0.1', '1.0.2'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    } 

    stages {   
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
                echo 'building the application'
                //sh 'mvn package'
            }
        } 

        stage("build") {
            steps {
                script {
                    gv.buildApp() //variable name and function name
                }
            }
        } 

        stage("test") {
            when {
                expression {
                  params.executeTests == true 
                }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }

        stage("deploy") {
            input {
                message "select the environment to deploy to" //required
                ok "Done" //when user confirms their selection
                parameters { //where the actual input options go
                    choice(name: 'ENV', choices: ['dev', 'staging', 'production'], description: '')
                }
            }
            steps{
                script {
                    gv.deployApp()
                    echo "deploying to ${ENV}" 
                }            
            }
        }   
    }    
}
