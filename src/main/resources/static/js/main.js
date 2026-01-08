/* Message Handler */
document.addEventListener('DOMContentLoaded', function() {
    closeMessages();
});

function closeMessages() {
    const messages = document.querySelectorAll('.message');
    messages.forEach(message => {
        const button = message.querySelector('button');
        if (button) {
            button.addEventListener('click', function() {
                message.style.display = 'none';
            });
        }
        
        // Auto-close after 5 seconds
        setTimeout(() => {
            if (message.style.display !== 'none') {
                message.style.display = 'none';
            }
        }, 5000);
    });
}

/* Delete Confirmation */
function confirmDelete(event) {
    if (!confirm('Are you sure you want to delete this user? This action cannot be undone.')) {
        event.preventDefault();
    }
}

/* Form Validation */
function validateUserForm(event) {
    const name = document.getElementById('name');
    const email = document.getElementById('email');
    const phone = document.getElementById('phone');
    
    let isValid = true;
    
    if (!name.value.trim()) {
        showFieldError(name, 'Name is required');
        isValid = false;
    } else {
        clearFieldError(name);
    }
    
    if (!email.value.trim()) {
        showFieldError(email, 'Email is required');
        isValid = false;
    } else if (!isValidEmail(email.value)) {
        showFieldError(email, 'Please enter a valid email');
        isValid = false;
    } else {
        clearFieldError(email);
    }
    
    if (!phone.value.trim()) {
        showFieldError(phone, 'Phone is required');
        isValid = false;
    } else {
        clearFieldError(phone);
    }
    
    if (!isValid) {
        event.preventDefault();
    }
    
    return isValid;
}

function isValidEmail(email) {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

function showFieldError(field, message) {
    field.style.borderColor = '#dc3545';
    field.style.boxShadow = '0 0 0 3px rgba(220, 53, 69, 0.1)';
    
    let errorSpan = field.nextElementSibling;
    if (!errorSpan || !errorSpan.classList.contains('field-error')) {
        errorSpan = document.createElement('span');
        errorSpan.className = 'field-error';
        errorSpan.style.cssText = 'display: block; color: #dc3545; font-size: 12px; margin-top: 5px;';
        field.parentNode.insertBefore(errorSpan, field.nextSibling);
    }
    errorSpan.textContent = message;
}

function clearFieldError(field) {
    field.style.borderColor = '#ddd';
    field.style.boxShadow = '';
    
    let errorSpan = field.nextElementSibling;
    if (errorSpan && errorSpan.classList.contains('field-error')) {
        errorSpan.remove();
    }
}
