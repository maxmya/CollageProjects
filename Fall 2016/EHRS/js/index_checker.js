/**
 * Created by maxmya on 11/8/16.
 */


try {
    var config = {
        apiKey: "AIzaSyCnyLJxhf2KjScY1uW06Bt5GeAkfYM0_Iw",
        authDomain: "bioinformatics-27985.firebaseapp.com",
        databaseURL: "https://bioinformatics-27985.firebaseio.com",
        storageBucket: "bioinformatics-27985.appspot.com",
        messagingSenderId: "997743646871"
    };
    firebase.initializeApp(config);


    firebase.auth().onAuthStateChanged(function (user) {
        if (user) {


        } else {


            window.location.replace("login.html");

        }
    });

} catch (error) {

    var dialog = document.querySelector('#err_dialog');

    if (!dialog.showModal) {
        dialogPolyfill.registerDialog(dialog);
    }

    dialog.querySelector('#err').innerHTML = error.message;
    dialog.showModal();
    dialog.querySelector('#close').addEventListener('click', function () {
        dialog.close();
    });


}
