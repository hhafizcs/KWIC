var storedSortedLines = [];

$(document).ready(function() {
	$("#lineInput").focus();
	
	$("#lineInput").keypress(function (e) {
	    if (e.keyCode == 13) {
	    	submitLine();
	    }
	});
});

function submitLine() {
	var line = $("#lineInput").val().trim();
	
	if(line == "") {
		return;
	}
	
	var requestData =
	{
		"line": line,
		"sortedLines": storedSortedLines
	};
	
    $.ajax({
    	type: "POST",
        url: "/submitLine",
        dataType: 'json',
        contentType: 'application/json',
        data: JSON.stringify(requestData),
        success: function(responseData) {
        	processResponse(responseData);
        }
    });
    
    $("#lineInput").val("");
    $("#lineInput").focus();
}

function processResponse(responseData) {
	var inputLine = responseData.inputLine;
	$("#inputTable").append("<tr><td style=\"color: " + inputLine.color + ";\">" + inputLine.line + "</td></tr>");
	
	var shiftedLines = responseData.shiftedLines;
	for(var i = 0; i < shiftedLines.length; i++) {
		$("#shiftedTable").append("<tr><td style=\"color: " + shiftedLines[i].color + ";\">" + shiftedLines[i].line + "</td></tr>");
	}
	
	storedSortedLines = [];
	$("#sortedTable").html("");
	var sortedLines = responseData.sortedLines;
	for(var i = 0; i < sortedLines.length; i++) {
		storedSortedLines.push(sortedLines[i]);
		$("#sortedTable").append("<tr><td style=\"color: " + sortedLines[i].color + ";\">" + sortedLines[i].line + "</td></tr>");
	}
}