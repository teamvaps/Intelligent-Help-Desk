'use strict';
 
angular.module('mainApp').factory('UserService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls, $cookie ) {
 
            var factory = {
                loadAllUsers: loadAllUsers,
                getAllUsers: getAllUsers,
                getUser: getUser,
                createUser: createUser,
                createTicket: createTicket,
                updateUser: updateUser,
                removeUser: removeUser,
                checkUser: checkUser,
                loadAllTickets: loadAllTickets,
                loadAllTicketsByName: loadAllTicketsByName,
                getAllTickets: getAllTickets,
                getAllTicketsByName: getAllTicketsByName,
                getTicket: getTicket,
                loadAllChecklist: loadAllChecklist,
                getAllChecklist: getAllChecklist,
//              setCredentials: setCredentials,
            };
 
            return factory;
 
            function loadAllUsers() {
                console.log('Fetching all users');
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API +'user/')
                    .then(
                        function (response) {
                            console.log('Fetched successfully all users');
                            $localStorage.users = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading users');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function getAllUsers(){
                return $localStorage.users;
            }
 
            function getUser(id) {
                console.log('Fetching User with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API + 'user/' + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully User with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading user with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function createUser(user) {
                console.log('Creating User');
                var deferred = $q.defer();
                $http.post(urls.USER_SERVICE_API+'user/', user)
                    .then(
                        function (response) {
                            loadAllUsers();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating User : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
            function createTicket(ticket) {
                console.log('Creating Ticket');
                var deferred = $q.defer();
                $http.post(urls.USER_SERVICE_API+'ticket/', ticket)
                    .then(
                        function (response) {
                            loadAllTickets();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating ticket : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            
            function updateUser(user, id) {
                console.log('Updating User with id '+id);
                var deferred = $q.defer();
                $http.put(urls.USER_SERVICE_API+'user/' + id, user)
                    .then(
                        function (response) {
                            loadAllUsers();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating User with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function removeUser(id) {
                console.log('Removing User with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.USER_SERVICE_API +'user/' + id)
                    .then(
                        function (response) {
                            loadAllUsers();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing User with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
            
            function checkUser(name, password){
            	console.log('Checking user '+name);
            	var deferred = $q.defer();
            	$http.post(urls.USER_SERVICE_API +'authenticate?name='+ name +'&password='+ password)
            	.then(
            			function(response){
                            deferred.resolve(response.data);
                            console.log('user logged in!');
            			},
            			function (errResponse) {
                            console.error('Error while logging in user ');
                            deferred.reject(errResponse);
                            
            			}
            	);
                return deferred.promise;
            }
            function loadAllTickets() {
                console.log('Fetching all tickets');
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API +'tickets/')
                    .then(
                        function (response) {
                            console.log('Fetched successfully all tickets');
                            $localStorage.tickets = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading tickets');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
            function loadAllChecklist() {
                console.log('Fetching all checklist');
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API +'checklist/')
                    .then(
                        function (response) {
                            console.log('Fetched successfully all checklist');
                            $localStorage.checklist = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading checklist');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

 
            function getAllTickets(){
            	console.log('returned tickets service');
                return $localStorage.tickets;
            }
            function getAllChecklist(){
            	console.log('returned checklist service');
                return $localStorage.checklist;
            }
            
            
            function loadAllTicketsByName(name) {
                console.log('Fetching all tickets by user' + name);
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API +'tickets/' + name)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all tickets by the user '+ name);
                            $localStorage.ticketsbyuser = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading tickets');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function getAllTicketsByName(){
            	console.log('returned tickets service');
                return $localStorage.ticketsbyuser;
            }
            function getTicket(id) {
                console.log('Fetching Ticket with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.USER_SERVICE_API + 'ticket/' + id)
                    .then(
                        function (response) {
                            console.log('Ticket successfully User with id :'+id);
                            deferred.resolve(response.data);
                            console.log(response.data.id);
                        },
                        function (errResponse) {
                            console.error('Error while loading user with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
            
            
            
            
            }
    
    		
    		
  
    
    ]);