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
            steps{
                script {
                    env. ENV = input message: "select the environment to deploy to", ok: "Done", parameters: [choice(name: 'ONE', choices: ['dev', 
                    'staging', 'production'], description: '')] //assign the global variable so the other stages can have it as well

                    gv.deployApp()
                    echo "deploying to ${ENV}" 
                }            
            }
        }   
    }    
}

- If you have one choice parameter you can assign the input result directly to a variable, like in any other programming language.
- This is a way to provide input and assign it to a variable especially if you have one input and if you are going to use that variable in other stages