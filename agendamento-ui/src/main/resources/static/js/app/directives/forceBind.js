appSisDoeAgendamentoOnline.directive('forceBind',  function() {
  return {
    require: '^form',
    priority: -1,
    link: function (scope, element, attrs, form) {
      element.bind('submit', function() {
        if (form.$valid) {
          angular.forEach(form, function(value, key) {  
            if (value.hasOwnProperty('$modelValue')) {
              if (!value.$viewValue) {
                value.$setViewValue("");
              }
            }
          });
        }
      });
    }
  };
});