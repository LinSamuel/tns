/**
 * poll
 * polls the currentviewnumservlet in {interval} number milliseconds
 * 
 * usage:
 * 
 * // on document ready
 * <script src="/js/polling.js"></script>
 * <script>
 * poll(1);
 * </script>
 * 
 * @param id {int} product id
 * @param interval {int} milliseconds
 */
function poll(id, interval) {
	var url = "CurrentViewNumServlet?productID=" + id;
	var xhr = new XMLHttpRequest();
	
	window.setInterval(function() {
		xhr.open('GET', url, true);
		xhr.send();
	}, interval);
}