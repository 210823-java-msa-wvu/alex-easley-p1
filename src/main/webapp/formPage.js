async function submitForm() {

    let url ='http://localhost:8080/Project_1/submitForm';
    let x = document.getElementById("urgent").checked;
    
    let form = {
        eventType: document.getElementById('formtype').value,
        startDate: document.getElementById('formdate').value,
        reqDate: document.getElementById('formtime').value,
        location: document.getElementById('formlocation').value,
        cost: document.getElementById('formcost').value,
        justify: document.getElementById('formjustif').value,
        description: document.getElementById('formdescrip').value,
        passed: x
    }
        let res = await fetch(url, {
            
            method: 'POST',
            body: JSON.stringify(form),
            headers: {
                'Content-Type': 'application/json',
                
            }
        });
        alert("Created");
       
}

function getCookie() {
    console.log("running")
    // Split cookie string and get all individual name=value pairs in an array
    var cookieArr = document.cookie.split(";");

    console.log(cookieArr[1])
    console.log(cookieArr[0])
    
    if (cookieArr[0] == "userType=employee" || cookieArr[1] == " userType=employee") {
        location.href = 'http://localhost:8080/Project_1/employeepage.html';
    }
    if (cookieArr[0] == "userType=supervisor" || cookieArr[1] == " userType=supervisor") {
        location.href = 'http://localhost:8080/Project_1/directsupervisorpage.html';
    }
    if (cookieArr[0] == "userType=departmenthead" || cookieArr[1] == " userType=departmenthead") {
        location.href = 'http://localhost:8080/Project_1/departmentheadpage.html';
    }
    if (cookieArr[0]  == "userType=benco" || cookieArr[1] == " userType=benco" || cookieArr[1]  == "userType=benco" || cookieArr[0] == " userType=benco") {
        location.href = 'http://localhost:8080/Project_1/bencopage.html';
    }
}
