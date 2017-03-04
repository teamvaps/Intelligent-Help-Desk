'use strict';
 
angular.module('mainApp').controller('UserController',
    ['UserService', '$scope', '$location','$http','$rootScope','$cookies', function(  UserService, $scope, $location, $http, $rootScope, $cookies) {
 
        var self = this;
        self.user = {};
        self.users=[];
        $scope.name;
        $scope.password;
        $rootScope.globals;
        $rootScope.currentUser;
 
        self.submit = submit;
        self.getAllUsers = getAllUsers;
        self.createUser = createUser;
        self.updateUser = updateUser;
        self.removeUser = removeUser;
        self.editUser = editUser;
        self.checkUser = checkUser;
        self.setCredentials = setCredentials;
        self.reset = reset;
 
        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;
 
        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;
 
        function submit() {
            console.log('Submitting');
            if (self.user.id === undefined || self.user.id === null) {
                console.log('Saving New User', self.user);
                createUser(self.user);
            } else {
                updateUser(self.user, self.user.id);
                console.log('User updated with id ', self.user.id);
            }
        }
 
        function createUser(user) {
            console.log('About to create user');
            UserService.createUser(user)
                .then(
                    function (response) {
                        console.log('User created successfully');
                        self.successMessage = 'User created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.user={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating User');
                        self.errorMessage = 'Error while creating User: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }
 
 
        function updateUser(user, id){
            console.log('About to update user');
            UserService.updateUser(user, id)
                .then(
                    function (response){
                        console.log('User updated successfully');
                        self.successMessage='User updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating User');
                        self.errorMessage='Error while updating User '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }
 
 
        function removeUser(id){
            console.log('About to remove User with id '+id);
            UserService.removeUser(id)
                .then(
                    function(){
                        console.log('User '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing user '+id +', Error :'+errResponse.data);
                    }
                );
        }
 
 
        function getAllUsers(){
            return UserService.getAllUsers();
        }
 
        function editUser(id) {
            self.successMessage='';
            self.errorMessage='';
            UserService.getUser(id).then(
                function (user) {
                    self.user = user;
                },
                function (errResponse) {
                    console.error('Error while removing user ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        
        function checkUser() {
            self.successMessage='';
            self.errorMessage='';
            UserService.checkUser($scope.name, $scope.password).then(
            	
                function (response) {
                		console.log('yoooo...you are logged in');
                        self.successMessage='Logged in!';
                        setCredentials($scope.name, $scope.password);
                        $location.path('dashboard');
                },
                function (errResponse) {
                    console.error('Error while logging in  user ');
                    self.errorMessage='Please check your username and password!';

                }
            );
        }
        
        function setCredentials(name, password) {
        	console.log('set credentials invoked!');
            var authdata = (name + ':' + password);
 
            $rootScope.globals = {
                currentUser: {
                    name: name,
                    authdata: authdata
                }
            };
            $http.defaults.headers.common['Authorization'] = 'Basic ' + authdata;
            var cookieExp = new Date();
            cookieExp.setDate(cookieExp.getDate() + 7);
            $cookies.putObject('globals', $rootScope.globals, { expires: cookieExp });
            console.log('cookie set!');
            $rootScope.currentUser = name;
        }
        
        
        function ClearCredentials() {
        	$rootScope.globals = {};
            $cookies.remove('globals');
            $http.defaults.headers.common.Authorization = 'Basic';
            $rootScope.currentUser = 'Guest';
        }
    
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.user={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }
    
    ]);