/**
 * 
 */

function doUpload(target, fileInputId, callback) {
	var formData = new FormData();

	var fileSelect = document.getElementById(fileInputId);
	if (fileSelect.files && fileSelect.files.length == 1) {
		var file = fileSelect.files[0]
		formData.set("file", file, file.name);
	}

	// Http Request
	var xhr = new XMLHttpRequest();

	if (callback) {
		xhr.onreadystatechange = function() {
			if (xhr.readyState === 4) {
				if (xhr.status === 200) {
					callback(xhr.response);
				} else {
					console.log(xhr);
					alert("Không upload được " + file.name + ".\nXin vui lòng thử lại.");
				}
				
			}
		}
	}

	xhr.open('POST', "http://localhost:8080/anesy/image/" + target);
	xhr.send(formData);
}