- Post-build Conditions:
    - always- gives directive of what needs to happens regardless of build failure or success
    - success- what needs to happen if the build is successful
    - failure- what needs to happens after a failure 

- Environmental Variables:
    - To find the environmental variables available for your build in Jenkins just add /env-vars.html to the end of your Jenkins url.
        - eg. 139.34.56.76/8080/env-vars.html.
    - In addition, you can also define your custom environmental variables as shown in environmental_variables.groovy file

- Input parameters in Jenkinsfile:
    - allows user to input data on any of the execution steps.
        - eg. input the envornemnt they would like to deploy the application to or the version of the app they would like to build
