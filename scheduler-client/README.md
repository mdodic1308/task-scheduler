# ShedulerClient
Angular based client web app for communicating with backend REST API fro managing of scheduled tasks

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 11.0.7.

## Local development
1. Run `npm install` for instaling the versions depending modules.
2. Run `ng serve` for starting the dev server. Navigate to `http://localhost:4200/`

Client app makes relative API calls to the dev server which redirects calls to the backed service. URL of the backend service can be configured in the  [proxy.conf.json](src/proxy.conf.json) file (by default, backend URL is set to http://localhost:8080)

##Known issues
1. When the API call is not successful, error pop-up box is missing
