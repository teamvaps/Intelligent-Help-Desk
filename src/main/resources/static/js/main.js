var mainApp = angular.module("mainApp", ['ui.router', 'ngStorage', 'ngResource', 'ngCookies', 'ngAnimate']);

mainApp.constant('urls',{
	BASE: 'http://localhost',
	USER_SERVICE_API: 'http://localhost/api/'
})

mainApp.run(run);

mainApp.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/');
    
    
	$stateProvider
		.state('home', {
			url:'/',
			templateUrl: "home.html"
		})
		.state('newticket', {
				url:'/login',
				templateUrl: "login.html",
			    controller:'UserController',
			    controllerAs:'ctrl',
				
	   })
	   	.state('track', {
			url:'/track',
			templateUrl: "track.html"
	   })
	   	.state('knowledgebase', {
			url:'/knowledgebase',
			templateUrl: "knowledgebase.html"
	   })
		.state('login', {
				url:'/login',
				templateUrl: "login.html",
		        controller:'UserController',
		        controllerAs:'ctrl',

	   })
	   	.state('login.register', {
				url:'/register',
				templateUrl: "register.html"
	   })
   		.state('dashboard', {
			url:'/dashboard',
			templateUrl: "dashboard.html",
		        controller:'UserController',
		        controllerAs:'ctrl',


	   })
	   	.state('dashboard.tickets', {
			url:'/tickets',
			templateUrl: "tickets.html",
		    controller:'UserController',
		    controllerAs:'ctrl',
	   })
	   	.state('dashboard.tickets.viewticket', {
			url:'/viewticket',
			templateUrl: "viewticket.html",
		    controller:'UserController',
		    controllerAs:'ctrl',
	   })

	   
	   	.state('dashboard.newticket', {
			url:'/newticket',
			templateUrl: "newticket.html",
		    controller:'UserController',
		    controllerAs:'ctrl',
	   })

	   .state('dashboard.userdisplay', {
			url:'/userdisplay',
			templateUrl: 'userdisplay.html',
            controller:'UserController',
            controllerAs:'ctrl',
            resolve: {
                users: function ($q, UserService) {
                    console.log('Load all users');
                    var deferred = $q.defer();
                  UserService.loadAllUsers().then(deferred.resolve, deferred.resolve);
                    return deferred.promise;
                }
            }
	   })
	   .state('dashboard.agent', {
			url:'/dashboard-agent',
			templateUrl: 'dashboard.agent.html'
	   })
	   .state('dashboard.org', {
			url:'/dashboard-org',
			templateUrl: 'dashboard.org.html'
	   })
	   .state('createuser', {
			url:'/createuser',
			templateUrl: 'createuser.html',
           controller:'UserController',
           controllerAs:'ctrl',
	   })
}]);

	run.$inject = ['$rootScope', '$location', '$cookies', '$http'];
	function run($rootScope, $location, $cookies, $http) {
		// keep user logged in after page refresh

		$rootScope.globals = $cookies.getObject('globals') || {};

		if ($rootScope.globals.currentUser) {
			$http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata;
		}

//    $rootScope.$on('$locationChangeStart', function (event, next, current) {
//        // redirect to login page if not logged in and trying to access a restricted page
//        var restrictedPage = $.inArray($location.path(), ['']) === -1;
//        var loggedIn = $rootScope.globals.currentUser;
//        if (restrictedPage && !loggedIn) {
//        	$location.path('/');
//        }
//    });
}
