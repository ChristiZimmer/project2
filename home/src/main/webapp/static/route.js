angular.module("atp", ["ngRoute"]);
angular.module("atp").config(function($locationProvider, $routeProvider) {
	$locationProvider.hashPrefix("");
	$routeProvider.when("/rankings", {
		//templateUrl: "",
		controller: "rankingController"
	}).when("/tournament/all", {
		templateUrl: "listTournaments.html",
		controller: "tournamentGetAllController"
	}).when("/tournament/create", {
		templateUrl: "createTournament.html",
		controller: "tournamentCreateController"
	}).when("/coach", {
		//templateUrl: "",
		controller: "coachController"
	}).when("/logout", {
		//templateUrl: "",
		controller: "logoutController"
	})
});