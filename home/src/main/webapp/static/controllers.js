angular.module("atp").controller("coachController", function($http, $scope) {
	// do something
});

angular.module("atp").controller("rankingController", function($http, $scope) {
	// do something
});

angular.module("atp").controller("tournamentController", function($http, $scope) {
	$http({
		method: "GET", url: "/tournament/all"
	}).then(function(response) {
		$scope.allTournaments = response.data;
	});
});

angular.module("atp").controller("logoutController", function($http, $scope) {
	// do something
});

angular.module("atp").controller("requestController", function($http, $scope) {
	$http({
		method: "GET", url: "/request/all"
	}).then(function(response) {
		$scope.allRequests = response.data;
	})
});