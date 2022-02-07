'use strict';

const loginForm = document.getElementById('login-form');
loginForm.addEventListener('submit', onLoginHandler);

function onLoginHandler(e) {
    e.preventDefault();
    const form = e.target;
    const userFormData = new FormData(form);
    const user = Object.fromEntries(userFormData);
    saveUser(user);
}