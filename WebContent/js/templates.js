/**
 * template.js
 * @author john ko
 * @license freemode
 * this will help templatize our html
 */

function templates(callback) {

  // get list of all templates
  var templates = document.getElementsByClassName("template");
  // collection of XMLHttpRequest
  var xhrs = [];

  // loop through each element with classname template
  for(var i = 0; i < templates.length; i++) {
    // current element
    var element = templates[i];
    var fileName = element.getAttribute("include");

    // set new xhr
    xhrs[i] = new XMLHttpRequest();
    // give an xhr a property of element;
    xhrs[i].element = element;

    xhrs[i].onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
        this.element.innerHTML = this.responseText;
        if (this.element.getAttribute("include") === "/templates/header.html") {
          callback();
        }

      }
    }

    xhrs[i].open("GET", fileName, true);
    xhrs[i].send();
  }
}

