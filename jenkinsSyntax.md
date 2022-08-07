- Post-build Conditions:
1. always- gives directive of what needs to happens regardless of build failure or success
2. success- what needs to happen if the build is successful
3. failure- what needs to happens after a failure 

- Environmental Variables:
    - to find the environmental variables available for your build in Jenkins just add /env-vars.html to the end of your Jenkins url.
        - eg. 139.34.56.76/8080/env-vars.html.
    - In addition, you can also define your custom environmental variables as shown in environmental_variables.groovy file