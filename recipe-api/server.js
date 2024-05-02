const express = require("express");
const app = express();

app.use(express.json);

app.get("/", (req, res) => {});

const router = require("./src/routes/recipes");
app.use("/recipes", router);

app.listen(3000);
