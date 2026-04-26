# Chat Models
Chat model is the lower level abstraction that represents the actual AI model interface. Its the core component that:
- Defines the contract for how to interact with the AI model (e.g., input/output formats, parameters).
- Handles the actual API call to the AI services
- Manages model specific configurations and parameters (e.g., temperature, max tokens, etc.)
- Provides foundational layer for AI interactions.

Examples of implementations include:
- `OpenAIChatModel`: A concrete implementation that interacts with OpenAI's API.
- `AzureOpenAIChatModel`: A concrete implementation that interacts with Azure's OpenAI service
- `GeminiChatModel`: A concrete implementation that interacts with Google's Gemini API.
- `MistralChatModel`: A concrete implementation that interacts with Mistral's API.

### Purpose : 
Encapsulates how to interact with a specific underlying AI provider.

Relationship between chatModel and chat client :
- ChatModel=Engine(does actual heavy lifting of actual AI communication)
- ChatClient=The steering wheel (provides high level interface, orchestration, and additional features like caching, logging, etc.)

ChatClient uses ChatModel to perform the actual AI interactions, while also providing additional functionalities like caching, logging, and orchestration. The ChatModel is responsible for the core communication with the AI provider, while the ChatClient provides a higher-level interface for users to interact with the AI models.

Example flow :
Your code -> Chat client -> Chat model -> AI provider