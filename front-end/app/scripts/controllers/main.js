'use strict';

angular.module('frontEndApp')
    .controller('MainCtrl', function ($scope, $http) {

        $scope.welcomeMessages = [{
            header: "None",
            message: "None"
            }];

        $http.get('http://localhost:8080/api/home/welcome')
            .success(function (data, status, headers, config) {
                $scope.welcomeMessages = data;
            })
            .error(function (data, status, headers, config) {
                console.log('Error of rest call');
            });
    });