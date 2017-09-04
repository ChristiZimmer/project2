angular.module("atp", ["ngRoute"]);
angular.module("atp").config(function($locationProvider, $routeProvider) {
	$locationProvider.hashPrefix("");
	$routeProvider.when("/rankings", {
		//templateUrl: "",
		controller: "rankingController"
	}).when("/tournament/all", {
		templateUrl: "listTournaments.html",
		controller: "tournamentManageController"
	}).when("/tournament/create", {
		templateUrl: "createTournament.html",
		controller: "tournamentCreateController"
	}).when("/tournament/delete", {
		templateUrl: "deleteTournament.html",
		controller: "tournamentManageController"
	}).when("/tournament/join", {
		templateUrl: "joinTournament.html",
		controller: "tournamentJoinController"
	}).when("/createNewUser", {
		templateUrl: "newUser.html",
		controller: "createUserController"
	}).when("/coach", {
		//templateUrl: "",
		controller: "coachController"
	}).when("/logout", {
		//templateUrl: "",
		controller: "logoutController"
	})
});