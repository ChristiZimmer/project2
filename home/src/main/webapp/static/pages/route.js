angular.module("atp", ["ngRoute"]);
angular.module("atp").config(function($locationProvider, $routeProvider) {
	$locationProvider.hashPrefix("");
	$routeProvider.when("/rankings", {
		//templateUrl: "",
		controller: "rankingController"
	}).when("/tournaments", {
		//templateUrl: "",
		controller: "tournamentController"
	}).when("/coach", {
		//templateUrl: "",
		controller: "coachController"
	}).when("/logout", {
		//templateUrl: "",
		controller: "logoutController"
	})
});