// Alt+shift+f
(function() {
    let btnAddFolder = document.querySelector("#addFolder");
    let btnAddTextFile = document.querySelector("#addTextFile");
    let divbreadcrumb = document.querySelector("#breadcrumb");
    let divContainer = document.querySelector("#container");
    let templates = document.querySelector("#templates");
    let resources = [];
    let cfid = -1; // initially we are at root (which has an id of -1)
    let rid = 0;

    btnAddFolder.addEventListener("click", addFolder);
    btnAddTextFile.addEventListener("click", addTextFile);

    // validation - unique, non-blank
    function addFolder() {
        let rname = prompt("Enter folder's name");
        if (!rname) {
            alert(" Not fine")
            return;
        }
        rname = rname.trim();
        // Uniquemess
        let AlreadyExist = resources.some(r => r.rname == rname && r.pid == cfid);
        if (AlreadyExist == true) {
            alert(rname + " is already in use. Try some other name");
            return;
        }
        let pid = cfid;
        rid++;
        addFolderHTML(rname, rid, pid);
        resources.push({
            rid: rid,
            rname: rname,
            rtype: "folder",
            pid: cfid
        });
        saveToStorage();
    }

    function addTextFile() {
        let tfname = prompt("Enter text file's name");
        console.log(tfname);
    }

    function deleteFolder() {
        console.log("In delete");
    }

    function deleteTextFile() {

    }

    function renameFolder() {
        let nrname = prompt("Enter folder's name");
        if (nrname != null) {
            nrname = nrname.trim();
        }
        // empty validation
        if (!nrname) {
            alert("Empty name is not allowed");
            return;
        }
        let spanrename = this;
        let divfolder = spanrename.parentNode;
        let divname = divfolder.querySelector("[purpose=name]");
        let orname = divname.innerHTML;
        let ridTBU = parseInt(divfolder.getAttribute("rid"));
        if (nrname == orname) {
            alert("Please enter the new name");
            return;
        }
        let AlreadyExist = resources.some(r => r.rname == nrname && r.pid == cfid);
        if (AlreadyExist == true) {
            alert(nrname + " already exist");
            return;
        }
        // Change HtML
        divname.innerHTML = nrname;
        // Change ram
        let resource = resources.find(r => r.rid == ridTBU);
        resource.rname = nrname;
        saveToStorage();
        console.log("In rename");
    }


    function renameTextFile() {

    }

    function viewFolder() {
        console.log("In view");
    }

    function viewTextFile() {

    }

    function addFolderHTML(rname, rid, pid) {
        let divFolderTemplate = templates.content.querySelector(".folder");
        let divFolder = document.importNode(divFolderTemplate, true); // makes a copy

        let spanRename = divFolder.querySelector("[action=rename]");
        let spanDelete = divFolder.querySelector("[action=delete]");
        let spanView = divFolder.querySelector("[action=view]");
        let divName = divFolder.querySelector("[purpose=name]");

        spanRename.addEventListener("click", renameFolder);
        spanDelete.addEventListener("click", deleteFolder);
        spanView.addEventListener("click", viewFolder);
        divName.innerHTML = rname;
        divFolder.setAttribute("rid", rid);
        divFolder.setAttribute("pid", pid);

        divContainer.appendChild(divFolder);
    }

    function saveToStorage() {
        let rjson = JSON.stringify(resources); // used to convert jso to a json string which can be saved
        localStorage.setItem("data", rjson);
    }

    function loadFromStorage() {
        let rjson = localStorage.getItem("data");
        if (!!rjson) {
            resources = JSON.parse(rjson);
            for (let i = 0; i < resources.length; i++) {
                if (resources[i].pid == cfid) {
                    addFolderHTML(resources[i].rname, resources[i].rid, resources[i].pid);
                }

                if (resources[i].rid > rid) {
                    rid = resources[i].rid;
                }
            }
        }
    }

    loadFromStorage();
})();
// to prevent namespace pollution