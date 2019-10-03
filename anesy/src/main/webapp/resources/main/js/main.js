/**
 * hidden Input: {id}ImgVal
 * file Input: {id}ImgFile
 * Image tag: {id}Img
 * 
 * options: {
 * 	targetId
 * 	onSuccess
 * 	onError
 * }
 */
function doUpload(target, id, options={}) {
	
	var hiddenInputF = id + 'ImgVal';
	var fileInputF = id + 'ImgFile';
	var imageF = id + 'Img';
	
	var formData = new FormData();

	var fileSelect = document.getElementById(fileInputF);
	if (fileSelect.files && fileSelect.files.length == 1) {
		var file = fileSelect.files[0]
		formData.set("file", file, file.name);
	}

	// Http Request
	var xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				var imageId = xhr.response;
				
				var url = location.origin + '/anesy/image/' + target;
				if(document.getElementById(imageF)) {
					document.getElementById(imageF).src = url + '/'+ imageId;
				}
				
				if (document.getElementById(hiddenInputF)) {
					document.getElementById(hiddenInputF).value = imageId;
				}
				
				if (options.onSuccess) {
					options.onSuccess(xhr.response);
				}
			} else {
				if (options.onError) {
					options.onError(xhr);
				} else {
					alert('Không upload được ' + file.name + '.\nXin vui lòng thử lại.');
				}
			}
			
		}
	}

	var url = location.origin + '/anesy/image/' + target;
	if (options.targetId) {
		url = url + '/' + options.targetId;
	}
	
	xhr.open('POST', url);
	xhr.send(formData);
}
