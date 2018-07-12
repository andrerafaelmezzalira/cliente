(function() {

	var FileUploadDirective = function() {
		return {
			restrict : 'A',
			require : "ngModel",
			link : function($scope, el, attrs, ngModel) {
				el.bind('change', function(event) {

					var reader = new FileReader();

					reader.onload = function(e) {
						ngModel.$setViewValue(reader.result);
					};

					reader.readAsDataURL(event.target.files[0]);

					$scope.$apply();
				});
			}
		};
	};

	angular.module('app.directives').directive('img', FileUploadDirective);

})();
