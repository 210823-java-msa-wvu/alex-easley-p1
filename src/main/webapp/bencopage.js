async function updateCost() {
    let url = "http://localhost:8080/Project_1/updateCost"

    let form = {
        requestId: document.getElementById("request_id").value,
        cost: document.getElementById("updateCostField").value
    }
    console.log(form)
    let res = await fetch(url, {
        method: 'POST',
        body: JSON.stringify(form),
        headers: {
            'Content-Type': 'application/json'
        }
        
    });
}

async function finalApproval() {
    let url = "http://localhost:8080/Project_1/update";

    let form = {
        employeeId: document.getElementById("request_id").value
    } 
    let res = await fetch(url, {
        method: 'POST',
        body: JSON.stringify(form),
        headers: {
            'Content-Type': 'application/json'
        }
    });
}

async function updateApprovals() {

    if (document.getElementById("updateCost").checked){
        console.log("here")
        updateCost();
    }
    else {
    let url = 'http://localhost:8080/Project_1/approvals';

    var x = document.getElementById("approve").checked;
    var y = document.getElementById("req_info_emp").checked;
    var z = document.getElementById("req_info_dh").checked;
    var zz = document.getElementById("req_info_ds").checked;
    
    let form = {
        request_id: document.getElementById("request_id").value,
        bcapproval: x,
        bcinforequeste: y,
        bcinforequestdh: z,
        bcinforequestds: zz
    }
    
    let res = await fetch(url, {
        method: 'POST',
        body: JSON.stringify(form),
        headers: {
            'Content-Type': 'application/json'
        }
    });location.reload();
}
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

async function getApprovalsFetch() {
    let url2 = 'http://localhost:8080/Project_1/approvals';
    let resA = await fetch(url2)
    let dataA = await resA.json()
    
    .catch(err => console.log(err))
    
    return dataA;
};

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
        if (dataA[i].dsinforequest == true 
            || dataA[i].dhinforequest == true 
            || dataA[i].dhinforequestds == true 
            || dataA[i].bcinforequeste == true 
            || dataA[i].bcinforequestdh == true 
            || dataA[i].bcinforequestds == true) 
            {  
            tableRow.appendChild(createTD("Requesting Information"))
            }
            else if(dataA[i].dsapproval == true && dataA[i].dhapproval == true) {
                if(data[i].grade == "A" || data[i].grade == "B" || data[i].grade == "C" || data[i].grade == "Presentation Passed" || data[i].grade == "Passed") {
                    tableRow.appendChild(createTD("Passed and Moved to Benco for Final Approval"))
                }
                else {tableRow.appendChild(createTD("Moved to Benco for Approval"))}
            }
            else if (dataA[i].dsapproval == true) {
                tableRow.appendChild(createTD("Moved to Department Head"))    
            }
        else { tableRow.appendChild(createTD("Open")) }
        
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
    if (document.getElementById('updateCost').checked) {
        document.getElementById('updateCostField').style.visibility = 'visible';
    }
    else document.getElementById('updateCostField').style.visibility = 'hidden';

}
function greeting(data) {
    console.log("greeting")
    

    let existDiv = document.getElementById("greeting");
    let linebreak = document.createElement("br");
    const newDiv = document.createElement("div");
    
    // and give it some content
    const newContent = document.createTextNode(`    Hello ${ data.username }`);
    
    const newContent2= document.createTextNode (`    Your available assistance is: ${ data.availAssist }`);
  
    existDiv.appendChild(newContent);
    existDiv.appendChild(linebreak)
    existDiv.appendChild(newContent2)
    

    document.body.insertBefore(newDiv, existDiv)
    
}



