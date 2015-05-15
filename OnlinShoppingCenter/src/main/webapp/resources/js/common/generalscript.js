
//generic function for the documnet.getElementBYID
function elByID(id){
	return document.getElementById(id);
}

function removeCart(val){
	elByID("productID").value = val;
}
