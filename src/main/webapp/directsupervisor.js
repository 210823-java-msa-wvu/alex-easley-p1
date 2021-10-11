async function updateApprovals() {

    let url = 'http://localhost:8080/Project_1/approvals';

    var x = document.getElementById("approve").checked;
    var y = document.getElementById("req_info").checked;
    console.log(document.getElementById("request_id"))
    
    let form = {
        request_id: document.getElementById("request_id").value,
        dsapproval: x,
        dsinforequest: y,
        dsdenialreason: document.getElementById('denialreason').value
    }
    location.reload();
    let res = await fetch(url, {
        method: 'POST',
        body: JSON.stringify(form),
        headers: {
            'Content-Type': 'application/json'
        }
    });
}
(async function getRequestsFetch() {
    let url2 = 'http://localhost:8080/Project_1/submitForm';


    let resR = await fetch(url2)
    let data = await resR.json()
    
    .then(data => {
        console.log(data);
        populatedata(data);
        
        
    })
    .catch(err => console.log(err));

})();

(async function getUserInfoFetch() {
    let url = 'http://localhost:8080/Project_1/login';

    
    let res = await fetch(url)
    let data = await res.json()
    
    .then(data => {
        console.log(data);
        greeting(data);
    })
    .catch(err => console.log(err));
    
})()

async function getApprovalsFetch() {
    let url2 = 'http://localhost:8080/Project_1/approvals';
    let resA = await fetch(url2)
    let dataA = await resA.json()
    
    .catch(err => console.log(err))
    
    //createStatusColumn(dataA);
    return dataA;
};

async function populatedata(data) {

    dataA = await getApprovalsFetch()
    console.log(dataA)
    
    let titles = [
        "ID",
        "Event Type",
        "Employee ID",
        "Grade",
        "Justification",
        "Cost",
        "Description",
        "Request Date",
        "Start Date",
        "Location",
        "",
        "",
        "Urgent?",
        "",
        "Status"
    ]

    let requestDiv = document.getElementById("requests")
    let table = document.createElement('table')
    table.setAttribute('border','0');
    table.setAttribute('class', 'table');
    let tableRow = document.createElement('tr')
    for (var i=0; i < titles.length; i++) {
        tableRow.appendChild(createTD(titles[i]))
    }
    table.appendChild(tableRow);

   
    for (var i = 0; i < data.length; i++) {
        let tableRow = document.createElement('tr')
        tableRow.appendChild(createTD(dataA[i].request_id))
        for (x in data[i]) {
            tableRow.appendChild(createTD(data[i][x]))
        }
        if (dataA[i].dsinforequest == false 
            && dataA[i].dhinforequest == false 
            && dataA[i].dhinforequestds == false 
            && dataA[i].bcinforequeste == false 
            && dataA[i].bcinforequestdh == false 
            && dataA[i].bcinforequestds == false) {
                
            if (dataA[i].dsapproval == true && dataA[i].dhapproval == true && dataA[i].bcapproval == true) {
                tableRow.appendChild(createTD("Awarded!"))
            }
            else if(dataA[i].dsapproval == true && dataA[i].dhapproval == true) {
                tableRow.appendChild(createTD("Moved to Benco"))
            }
            else if (dataA[i].dsapproval == true) {
                tableRow.appendChild(createTD("Moved to Department Head"))    
            }
            else { tableRow.appendChild(createTD("Open")) }
        }
        else {
            tableRow.appendChild(createTD("Requesting Information"))
        }
        table.appendChild(tableRow);	
    }
    requestDiv.appendChild(table);
    
};

function createTD(data) {

        let tableData = document.createElement('td')
        tableData.textContent = data;
        return tableData;
}

function yesnoCheck() {
    if (document.getElementById('deny').checked) {
        document.getElementById('denialreason').style.visibility = 'visible';
    }
    else document.getElementById('denialreason').style.visibility = 'hidden';

}

async function createStatusColumn(data) {

    let tableRow = document.createElement('tr')
    for (var i = 0; i < data.length; i++) {
        
    

}
}
function greeting(data) {
    console.log("greeting")
    

    let existDiv = document.getElementById("greeting");
    let linebreak = document.createElement("br");
    const newDiv = document.createElement("div");
    existDiv.setAttribute("style","margin-left:30")
    // and give it some content
    const newContent = document.createTextNode(`    Hello ${ data.username }`);
    
    const newContent2= document.createTextNode (`    Your available assistance is: ${ data.availAssist }`);
  
    existDiv.appendChild(newContent);
    existDiv.appendChild(linebreak)
    existDiv.appendChild(newContent2)
    

    document.body.insertBefore(newDiv, existDiv)
    
}