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
	}).when("/request/all", {
		templateUrl: "listRequests.html",
		controller: "getAllRequestController"
	}).when("/request/create", {
		templateUrl: "createRequest.html",
		controller: "createRequestController"
	}).when("/request/delete", {
		templateUrl: "deleteRequest.html",
		controller: "deleteRequestController"
	}).when("/request/update", {
		templateUrl: "updateRequest.html",
		controller: "getAllRequestController"
	}).when("/coach/all", {
		
	})
});