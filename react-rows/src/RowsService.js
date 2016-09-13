export default class RowsService { 

    getRows(uri) { 
        console.log("Fetching uri:",uri);
        let result = new Promise(function (resolve, reject) {
            let xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () { 
                if (xhr.readyState == 4 && xhr.status == 200) {
                    let raw = xhr.responseText;
                    console.log(raw); 
                    resolve(JSON.parse(raw));
                }
            };
            xhr.open("GET", uri, true);
            xhr.send(null);
        });
        return result;
    }    
     
}