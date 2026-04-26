# Spring AI

1. Framework for integrating AI into Spring applications.
2. Simplifies adding Generative AI capabilities using springs modular, pojo based design.
3. Connects enterprise data and APIs with AI models seamlessly.

## Features'

* Multi-provider support (OpenAI, Azure, etc.)
* MCP support: allows building MCP client and servers easily.
* Vector store integration: Supports RAG with Pinecone, Redis, PostgresSQL/pgvector, MongoDb, Weaviate, and more.
* Advanced patterns: Chat memory, tool use, agent execution, and more.
* Observability and Gaurdrails: Built-in support for monitoring and safety features.

## Typical use cases

* AI-powered customer support chatbots'
* Natural language search over documents
* Personalized recommendation systems
* Data processing

## Understanding Message Roles in LLM

When interacting with LLM we send prompts that consist of messages. Each message has a role that indicates its purpose in the conversation. The main roles are:

* System: Provides instructions or context to the model. It sets the behavior of the assistant.
* User: Represents the input from the user. This is what the user is asking or saying
* Assistant: Represents the response from the model. This is what the model generates based on the user input and system instructions.
* Function: Represents a function call that the model can make. This is used when the model needs to execute a specific function as part of its response.

### Analogy

Think of a conversation with an LLM like a play. The system is the director, giving instructions to the actors (the model). The user is the audience, asking questions or making statements. The assistant is the actor responding to the audience based on the director's instructions. The function role is like a stagehand that can perform specific tasks when called upon by the actor.


### Defaults in SPring AI
These refers to preconfigured values or behaviour that is applied automatically to each request made through the ChatClient - unless overridden.

These are useful when
- You want to repeat the same system messages again and again
- You have consistent role or tone for your assistant.
- You have consistent logging or tool behaviour across calls.

defaultSystem() - Defines a default system message which sets the behaviour or role of the assistant.

### Prompt templates in Spring AI
- Simplifies prompt construction
- Makes prompts reusable and maintanable
- Supports parameterized placeholder

You can store prompt templates in resources folder. Use it by @Value

### Prompt Stuffing
Prompt Stuffing=Giving the LLM an open book before answering a question.
- We include contextual data or reference text along with the user's question
- LLM uses this extra content to answer the question accurately.
- This technique is known as in-context learning or retrieval-augmented prompting.

### Advisors
Advisors are interceptors or middleware for the prompt flow
They allow to:
- Pre or post process the prompt data.
- Add custom login or auditing
- Inject additional behaviour without modifying core logic
- Chain multiple behaviours cleanly.

User -> ChatClinet -> [Advisors] -> LLM -> Response -> [Advisors] -> User

### Understanding ChatOptions in SpringAI :
It is a configuration in SpringAI that allows you to customize how a language model behaves during chat/completion calls. Think of it like tuning panel for your AI model - Limit can be set, adjust creativity, randomness, verbosity, control response length abd more.
| Option           | Meaning                                                                 |
|-----------------|-------------------------------------------------------------------------|
| model           | Which LLM model to use (e.g., gpt-4, gpt-3.5-turbo, etc.)               |
| frequencyPenalty| Reduces repetition. Higher = less repetition                            |
| presencePenalty | Encourages mentioning new topics                                        |
| temperature     | Controls creativity. 0 = focused, 1 = random                            |
| topP            | Controls randomness (nucleus sampling)                                  |
| stopSequences   | Stop generating when specific phrases are found                         |
| maxTokens       | Maximum number of tokens (words/chars) in the reply                     |
| topK            | Controls how many top choices are considered                            |

### Structured output converter in SpringAI :
LLMs typically return plain text responses. But we often need JSON, XML or Java POJOs, because structured data is easier to parse, use and integrate in applications.

These converters add formatting instruction to guide the model, ensures it replies in parseable format.
Also convers raw text into java objects or custom classes.

## Generative AI(GenAI)
Generative AI refers to a class of artificial intelligence models that can generate new content, such as text, images, audio, or even code. These models learn patterns from large datasets and can create original outputs based on that learning.

### Generative AI Family tree :
It is part of bigger family of techniques in AI, including:
- Artificial Intelligence : Making computers perform tasks that typically require human intelligence. AI is umbrella term for smart machines that can perform tasks like learning, reasoning, problem-solving, and understanding natural language.
- Machine Learning : Smaller part of AI that teach computer by giving examples. It allows machines to learn from data and improve performance over time without being explicitly programmed. It does not implement strict rules. Computer determines the patterns by its own.
- Deep Learning : Subset of machine learning that uses neural networks with many layers (hence "deep"). It is particularly effective for tasks like image recognition, natural language processing, and generative AI. Deep learning models can automatically learn features from raw data, making them powerful for complex tasks.
- Neural networks : A type of machine learning model inspired by the structure of the human brain. Neural networks consist of layers of interconnected nodes (neurons) that process and transmit information. They are the foundation for deep learning models and are used in various applications, including generative AI.
- NLP(Natural Language Processing) : A field of AI that focuses on the interaction between computers and human language. NLP enables machines to understand, interpret, and generate human language in a valuable way. It is a key component of generative AI models that work with text.
- Generative AI : A specific type of AI that focuses on creating new content. Generative AI models can produce text, images, audio, and more. They are trained on large datasets and can generate original outputs based on the patterns they have learned. Examples include GPT-3 for text generation and DALL-E for image generation.
- LLMs(Large Language Models) : A type of generative AI model that is specifically designed for natural language processing tasks. LLMs are trained on vast amounts of text data and can generate human-like text based on the input they receive. They are used for tasks such as chatbots, content creation, and language translation.

### Types of Generative AI models :
LLMs(text generation) and Diffusion(image, audio, video) models are two popular types of generative AI models, each with its own strengths and applications.

LLMs have one main job of guessing the next word based on input provided. Using LLM wrappers like ChatGPT we get full sentences.
Process of breaking the original text into token is called tokenization. A token can be character or word or part of word depending on the model.

Text -> Tokens -> Token Id -> Vectors.

Embeddings are numerical representations of text that capture semantic meaning. They are used to compare and understand the relationships between different pieces of text. For example, the words "king" and "queen" would have similar embeddings because they are related in meaning.
This is the way of teaching the model to understand the meaning of words and sentences, which is crucial for generating coherent and contextually relevant text.