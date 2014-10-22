function File(){
	this.fileObject = new ActiveXObject("Scripting.FileSystemObject");
}

File.prototype = {
	openFile : function(url){
		var result;
		// alert(url);
		if(this.fileObject.FileExists(url)){
			var fileOpen = this.fileObject.OpenTextFile(url, 1);
			result = fileOpen.ReadAll();
			fileOpen.close();
		} else alert("Error");
	},
	writeFile : function(url, text){
		var fileWrite = this.fileObject.CreateTextFile(url, true);
		fileWrite.write(text);
		fileWrite.close();
	},
	deleteFile : function(url){
		this.fileObject.DeleteFile(url);
	}
}