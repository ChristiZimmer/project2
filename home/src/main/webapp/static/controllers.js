angular.module("atp").controller("coachController", function($http, $scope) {
	// do something
});

angular.module("atp").controller("rankingController", function($http, $scope) {
	// do something
});

angular.module("atp").controller("tournamentManageController", function($http, $scope) {
	$http({
		method: "GET", url: "/home/tournament/all"
	}).then(function(response) {
		$scope.allTournaments = response.data;
	});
	$scope.deleteTournament = function(){
		$http({
			method: "DELETE", url: "/home/tournament/delete/" + $scope.tournamentId
		}).then(function(response) {
			if(response.statusText === "No Content"){
				window.alert("Tournament Deleted");
			}
		}, function(reason) {
			window.alert("Unable to delete tournament");
		});
	}
});

angular.module("atp").controller("tournamentCreateController", function($http, $scope) {
	$http({
		method: "GET", url: "/home/coach/all"
	}).then(function(response) {
		$scope.allCoaches = response.data;
	});
	$scope.createTournament = function(){
		$http.post("/home/tournament/create", $scope.tournament)
		.then(function(value) {
			window.alert("Tournament Added");
		}, function(reason) {
			window.alert("Unable to add tournament");
		})
	}
});

angular.module("atp").controller("tournamentJoinController", function($http, $scope) {
	$http({
		method: "GET", url: "/home/player/all"
	}).then(function(response) {
		$scope.allPlayers = response.data;
	});
	$http({
		method: "GET", url: "/home/tournament/all"
	}).then(function(response) {
		$scope.allTournaments = response.data;
	});
	$scope.joinTournament = function(){
		var urlString = "/home/tournament/join/" + $scope.tournamentId + "/" + $scope.playerId;
		$http({
			method: "PUT", url: urlString
		}).then(function(response) {
			if(response.statusText === "OK"){
				window.alert("Joined Tournament");
			}else{
				window.alert(response.statusText);
			}
		}, function(reason) {
			window.alert("Unable to join tournament");
		});
	}
});

angular.module("atp").controller("createUserController", function($http, $scope) {
	$scope.createUser = function(){
		$http({
			method: "POST", url: "/home/user/create", data: $scope.newUser
		}).then(function(value) {
			window.alert("User Created");
		}, function(reason) {
			if(reason.statusText == "Conflict"){
				window.alert("Username Already taken")
			}else{
				window.alert("Unable to create user");
			}
		})
	}
});

angular.module("atp").controller("logoutController", function($http, $scope) {
	// do something
});