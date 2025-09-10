<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>AI Chatbot</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
         body {
                    background: #f8f9fa;
                }
                .chat-container {
                    max-width: 700px;
                    margin: 50px auto;
                    background: white;
                    border-radius: 15px;
                    box-shadow: 0px 4px 15px rgba(0,0,0,0.1);
                    display: flex;
                    flex-direction: column;
                    height: 80vh;
                }
                .chat-messages {
                    flex: 1;
                    overflow-y: auto;
                    padding: 15px;
                }
                .message {
                    margin-bottom: 15px;
                    display: flex;
                }
                .message.user {
                    justify-content: flex-end;
                }
                .message.bot {
                    justify-content: flex-start;
                }
                .message .bubble {
                    padding: 10px 15px;
                    border-radius: 20px;
                    max-width: 70%;
                }
                .message.user .bubble {
                    background: #0d6efd;
                    color: white;
                    border-bottom-right-radius: 5px;
                }
                .message.bot .bubble {
                    background: #e9ecef;
                    border-bottom-left-radius: 5px;
                }
                .chat-input {
                    border-top: 1px solid #ddd;
                    padding: 10px;
                    display: flex;
                }
                .chat-input input {
                    flex: 1;
                    border: none;
                    outline: none;
                    padding: 10px;
                }
                .chat-input button {
                    border-radius: 50%;
                    width: 45px;
                    height: 45px;
                }

    </style>
</head>
<body>
<div class="chat-container">
    <div class="chat-messages" id="chat-box">
        <div class="message bot">
            <div class="bubble">👋 Hi! I’m your AI chatbot. How can I help you?</div>
        </div>
    </div>
    <form class="chat-input" onsubmit="sendMessage(event)">
        <input type="text" id="userInput" placeholder="Type your message..." required>
        <button class="btn btn-primary" type="submit">➤</button>
    </form>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
function sendMessage(event) {
    event.preventDefault();
    const input = document.getElementById("userInput");
    const message = input.value.trim();
    if (!message) return;
    addMessage("user", message);
    input.value = "";

    $.ajax({
        type: "GET",
        url: "/ai/chat/" + encodeURIComponent(message),
        dataType: "text",
        success: function (data) {
            addMessage("bot", data);
        },
        error: function (jqxhr, textStatus, errThrown) {
            let errorMsg = jqxhr.responseText || errThrown || "Unknown error";
            addMessage("bot", "⚠️ Error: " + errorMsg);
        }
    });
}

function addMessage(sender, text) {
    const chatBox = document.getElementById("chat-box");
    const div = document.createElement("div");
    div.className = "message " + sender;
    div.innerHTML = `<div class="bubble">`+text+`</div>`;
    chatBox.appendChild(div);
    chatBox.scrollTop = chatBox.scrollHeight;
}
</script>
</body>
</html>
