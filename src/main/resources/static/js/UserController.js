'use strict';
 
angular.module('mainApp').controller('UserController',
    ['UserService', '$scope', '$location','$http','$rootScope','$cookies', '$stateParams', function(  UserService, $scope, $location, $http, $rootScope, $cookies, $stateParams) {
 
        var self = this;
        self.user = {};
        self.users=[];
        $scope.name;
        $scope.password;
        $scope.ticketId;
        $rootScope.globals;
        $scope.ticket;
        $scope.authorid = 1;

 
        self.submit = submit;
        self.submitTicket = submitTicket;
        self.getAllUsers = getAllUsers;
        self.createUser = createUser;
        self.createTicket = createTicket;
        self.updateUser = updateUser;
        self.removeUser = removeUser;
        self.editUser = editUser;
        self.checkUser = checkUser;
        self.setCredentials = setCredentials;
        self.clearCredentials = clearCredentials;
        self.reset = reset;
        self.getAllTickets = getAllTickets;
        self.loadAllTicketsByName = loadAllTicketsByName;
        self.getAllTicketsByName = getAllTicketsByName;
        self.getTicketId = getTicketId;
        self.getTicket = getTicket;
        self.loadAllChecklist = loadAllChecklist;
        self.getAllChecklist = getAllChecklist;
        self.submitList = submitList;
        
//        self.getAllTicketBy = getAllTicketBy;
//        self.createTicket = createTicket;
//        self.updateTicket = updateTicket;
//        self.removeTicket = removeTicket;
//        self.editTicket = editTicket;
 
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
//                updateUser(self.user, self.user.id);
                console.log('User updated with id ', self.user.id);
            }
        }
        function submitTicket() {
            console.log('Submitting');
            if (self.ticket.id === undefined || self.ticket.id === null) {
                console.log('Saving New ticket', self.ticket);
                createTicket(self.ticket);
            } else {
                updateUser(self.ticket, self.ticket.id);
                console.log('ticket updated with id ', self.ticket.id);
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
 
        function createTicket(ticket) {
            console.log('About to create ticket');
            UserService.createTicket(ticket)
                .then(
                    function (response) {
                        console.log('ticket created successfully');
                        self.successMessage = 'Ticket created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.ticket={};
                        $scope.myForm1.$setPristine();
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
                        $location.path('dashboard/tickets');
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
        
        
        function clearCredentials() {
        	$rootScope.globals = {};
            $cookies.remove('globals');
            $http.defaults.headers.common.Authorization = 'Basic';
            console.log('Cookies cleared!');
            $location.path('/');
            
        }
    
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.user={};
            $scope.myForm.$setPristine(); //reset Form
        }
        function getAllTickets(){
        	console.log('returned tickets controll');

            return UserService.getAllTickets();
        }
        function loadAllTicketsByName(){
        	UserService.loadAllTicketsByName($rootScope.currentUser);
        }
        
        function loadAllChecklist(){
        	console.log('invoked checklist');

        	UserService.loadAllChecklist();

        }
        
        function getAllChecklist(){

            return UserService.getAllChecklist();

        }
        
        function getAllTicketsByName(){
        	console.log('returned tickets controll');

            return UserService.getAllTicketsByName();
        }
        
        function getTicketId(){
        	$scope.ticketId = $stateParams.ticketId;
        	console.log('Ticket id is '+$scope.ticketId);
        }
        
        function getTicket(){
        	console.log('ticket retrieval control started');
        	$scope.ticketId = $stateParams.ticketId;
        	UserService.getTicket($scope.ticketId).then(
                	
                    function (response) {
                    		$scope.ticket=response;
                    		console.log('yoooo...got your ticket' + $scope.ticket.id);

                    },
                    function (errResponse) {
                        console.error('Error getting ticket ');

                    }
                );
        	
        }
        function submitList(){
        	console.log('this has been invoked');
        }
        
        
        
        
    }
    
    
    
    ]);