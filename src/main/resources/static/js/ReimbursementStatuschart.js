var chartDataStr = decodeHtml(dataChart);
var chartJsonArray = JSON.parse(chartDataStr);

var arrayLength = chartJsonArray.length;

var countData = [];
var labelData = [];

for(var i = 0; i < arrayLength; i++){
	countData[i] = chartJsonArray[i].count;
	labelData[i] = chartJsonArray[i].label;
}

// For a pie chart
new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    // The data for our dataset
    data: {
        labels: labelData,
        datasets: [{
            label: 'My dataset',
            backgroundColor: ["#3cba9f", "#3e95cd", "#ff2424"],
            data: countData
        }]
    },

    // Configuration options go here
    options: {
    	title: {
    		display: true,
    		text: 'Reimbursemnt Status Data'
    	}
    	
    }
});

// "[{"count": 2, "label": "Pending"},{"count":1, "label": "Approved"},{"count": 1, "label": "Denied"}]"
function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}