from pathlib import Path

edits = {
    "DataCenter.java": [
        [
            "                skill.strOptions = reader.readUTF();",
            "                skill.strOptions = reader.readUTF();\n                if (skill.idTemplate == 38) {\n                    String[] options = skill.strOptions.split(\";\", -1);\n                    for (int i = 0; i < options.length; i++) {\n                        if (options[i].startsWith(\"318,\")) {\n                            int reduction = Integer.parseInt(options[i].substring(4));\n                            options[i] = \"318,\" + Math.round(reduction * 0.70);\n                        }\n                    }\n                    skill.strOptions = String.join(\";\", options);\n                }"
        ]
    ],
    "Item.java": [
        [
            "this.level = (byte) (var4 / 200);",
            "this.level = (byte) Math.min(19, var4 / 200);"
        ],
        [
            "    public void a(int var1) {",
            "    public void a(int var1) {\n        var1 = Math.max(0, Math.min(19, var1));"
        ],
        [
            "this.level = var1.readByte();",
            "this.level = (byte) Math.max(0, Math.min(19, var1.readByte()));"
        ]
    ],
    "Char.java": [
        [
            "this.sachChienDau = var1.readByte();",
            "this.sachChienDau = (byte) Math.max(0, Math.min(18, var1.readByte()));"
        ],
        [
            "var3.level = var0.readByte();",
            "var3.level = (byte) Math.max(0, Math.min(19, var0.readByte()));"
        ]
    ],
    "GameSrc.java": [
        [
            "var6.y.sachChienDau = var8.reader.dis.readByte();",
            "var6.y.sachChienDau = (byte) Math.max(0, Math.min(18, var8.reader.dis.readByte()));"
        ],
        [
            "var2.sachChienDau = var1.reader.dis.readByte();",
            "var2.sachChienDau = (byte) Math.max(0, Math.min(18, var1.reader.dis.readByte()));"
        ]
    ],
    "LangLa_ar.java": [
        [
            "                this.a(var1, this.h[3]);",
            "                if (this.a[0] != null && this.w > 0 && this.d == 0) {\n                    mFont.b(mFont.d, var1, \"Điểm đá: \" + this.v + \"/\" + this.w, 149, this.a_() + 154, 0, -30976, -16777216);\n                }\n                this.a(var1, this.h[3]);"
        ]
    ],
    "LangLa_y.java": [
        [
            "         int var2;\n         if (this.x != null)",
            "         if (this.a[0] != null) {\n            mFont.b(mFont.d, var1, \"Bạc cần: 0 | Ngọc đã chọn: \" + this.y, 150, this.a_() + 158, 0, -1, -16777216);\n         }\n         int var2;\n         if (this.x != null)"
        ],
        [
            "mFont.b(mFont.d, var1, \"- \" + Caption.lN,",
            "mFont.b(mFont.d, var1, \"- Ngọc dư được giữ lại\","
        ]
    ]
}

for filename, changes in edits.items():
    path = Path("src/beatdz") / filename
    source = path.read_text(encoding="utf-8")
    for old, new in changes:
        if source.count(old) != 1:
            raise SystemExit(f"{filename}: expected one occurrence of {old!r}, got {source.count(old)}")
        source = source.replace(old, new, 1)
    path.write_text(source, encoding="utf-8")
