export class ScheduledTask {
    id: number;
    name: String;
    recurrency: String;
    code: String;

    constructor(id: number, name: String, recurrency: String, code: String) {
        this.id = id;
        this.name = name;
        this.recurrency = recurrency;
        this.code = code;
    }

}