package functions;

class FunctionNode {
    private FunctionPoint_3 value;
    private FunctionNode next;
    private FunctionNode prev;
    public FunctionNode() {
        /*
         * Конструктор по умолчанию
         */
        this.value = null;
        this.next = this;
        this.prev = this;
    }
    public FunctionNode(FunctionPoint_3 value){
        /*
         * Конструктор с параметром в виде значения узла, но без ссылок на предыдущий и последующий узлы
         */
        this.value = value;
        this.next = this;
        this.prev = this;
    }
    public FunctionNode(FunctionPoint_3 value, FunctionNode next){
        /*
         * Конструктор с параметрами в виде значения узла и ссылки на следующий узел
         */
        this.value = value;
        this.next = next;
        this.prev = this;
    }
    public FunctionNode(FunctionNode functionNode){
        /*
         * Конструктор копирования
         */
        this.value = functionNode.value;
        this.next = functionNode.next;
        this.prev = functionNode.prev;
    }
    public FunctionNode(FunctionPoint_3 value, FunctionNode next, FunctionNode prev){
        /*
         * Конструктор с параметрами в виде значения узла, ссылки на следующий и предыдущий узлы
         */
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public FunctionPoint_3 getValue(){
        /*
         * Возвращает значение узла
         */
        return this.value;
    }
    public void setValue(FunctionPoint_3 value){
        /*
         * Устанавливает значение узла
         */
        this.value = value;
    }
    public FunctionNode getNext(){
        /*
         * Возвращает ссылку на следующий узел для сохранения инкапсуляции
         */
        return this.next;
    }
    public FunctionNode getPrev(){
        /*
         * Возвращает ссылку на предыдущий узел для сохранения инкапсуляции
         */
        return this.prev;
    }
    public void setNext(FunctionNode next){
        /*
         * Устанавливает ссылку на следующий узел
         */
        this.next = next;
    }
    public void setPrev(FunctionNode prev){
        /*
         * Устанавливает ссылку на предыдущий узел
         */
        this.prev = prev;
    }
}

public class LinkedListTabulatedFunction implements TabulatedFunction{
    private final FunctionNode head;
    public int length;
    public LinkedListTabulatedFunction(){
        /*
         * Конструктор по умолчанию, создаём только голову списка
         */
        this.head = new FunctionNode();
        this.length = 0;
    }
    public LinkedListTabulatedFunction(double left_border, double right_border, int amount){
        /*
         * Конструктор с параметром, равным количеству элементов в списке
         */
        this.head = new FunctionNode();
        FunctionNode functionNode = new FunctionNode(new FunctionPoint_3(left_border, 0));
        this.head.setNext(functionNode);
        FunctionNode ptr;
        double difference = (right_border - left_border) / (amount - 1);
        for(int i = 1; i < amount; i++){
            ptr = new FunctionNode(new FunctionPoint_3(left_border + i * difference, 0));
            functionNode.setNext(ptr);
            ptr.setPrev(functionNode);
            functionNode = ptr;
        }
        functionNode.setNext(this.head.getNext());
        this.head.getNext().setPrev(functionNode);
        this.length = amount;
    }
    public LinkedListTabulatedFunction(double left_border, double right_border, double[] values){
        /*
         * Конструктор с параметрами в виде границ области определения функции и значений функции в этой области
         */
        this.head = new FunctionNode();
        FunctionNode functionNode = new FunctionNode(new FunctionPoint_3(left_border, values[0]));
        FunctionNode ptr;
        this.head.setNext(functionNode);
        double difference = (right_border - left_border) / (values.length - 1);
        for(int i = 1; i < values.length; i++){
            ptr = new FunctionNode(new FunctionPoint_3(left_border + i * difference, values[i]));
            functionNode.setNext(ptr);
            ptr.setPrev(functionNode);
            functionNode = ptr;
        }
        this.head.getNext().setPrev(functionNode);
        functionNode.setNext(this.head.getNext());
        this.length = values.length;
    }
    public LinkedListTabulatedFunction(int length){
        /*
          Конструктор с параметром, равным количеству элементов в списке
         */
        this.head = new FunctionNode();
        FunctionNode functionNode = new FunctionNode();
        this.head.setNext(functionNode);
        FunctionNode ptr;
        for(int i = 0; i < length; i++){
            ptr = new FunctionNode();
            functionNode.setNext(ptr);
            ptr.setPrev(functionNode);
            functionNode = ptr;
        }
        functionNode.setNext(this.head.getNext());
        this.head.getNext().setPrev(functionNode);
        this.length = length;
    }
    public LinkedListTabulatedFunction(FunctionNode node){
        /*
          Конструктор с параметром, задающим начальный элемент
         */
        this.head = new FunctionNode();
        FunctionNode ptr = new FunctionNode(node);
        this.head.setNext(ptr);
        this.length = 1;
    }
    public LinkedListTabulatedFunction(double value){
        /*
          Конструктор с параметром, равным значению функции в начальном элементе
         */
        this.head = new FunctionNode();
        FunctionNode ptr = new FunctionNode(new FunctionPoint_3(value, 0));
        this.head.setNext(ptr);
        this.length = 1;
    }
    public FunctionNode getNodeByIndex(int index) throws FunctionPointIndexOutOfBoundsException{
        /*
         * Возвращает узел по индексу
         */
        if (index > this.length - 1 || index < 0) {
            throw new FunctionPointIndexOutOfBoundsException();
        }
        FunctionNode ptr = this.head.getNext();
        for(int i = 0; i < index; i++){
            ptr = ptr.getNext();
        }
        return ptr;
    }
    public FunctionNode addNodeToTail(){
        /*
         * Добавляет элемент в конец списка и возвращает ссылку на него
         */
        if (this.length == 0) {
            return this.addNodeByIndex(0, new FunctionPoint_3());
        }
        FunctionNode node = new FunctionNode(new FunctionPoint_3());
        node.setPrev(this.head.getNext().getPrev());
        this.head.getNext().getPrev().setNext(node);
        this.head.getNext().setPrev(node);
        node.setNext(this.head.getNext());
        ++length;
        return node;
    }
    public FunctionNode addNodeByIndex(int index, FunctionPoint_3 point) throws FunctionPointIndexOutOfBoundsException{
        /*
         * Добавляет элемент в список по индексу и возвращает ссылку на элемент
         */
        if (index > this.length - 1 || index < 0) {
            throw new FunctionPointIndexOutOfBoundsException();
        }
        FunctionNode node = new FunctionNode(point);
        if (index == 0 && this.length == 0){
            this.head.setNext(node);
        } else if (index == 0) {
            FunctionNode ptr = this.head.getNext();
            ptr.getPrev().setNext(node);
            node.setNext(ptr);
            node.setPrev(ptr.getPrev());
            ptr.setPrev(node);
            this.head.setNext(node);
        } else {
            FunctionNode ptr = this.head.getNext();
            for (int i = 0; i <= index; i++) {
                ptr = ptr.getNext();
            }
            node.setPrev(ptr.getPrev());
            node.setNext(ptr);
            ptr.getPrev().setNext(node);
            ptr.setPrev(node);
        }
        ++length;
        return node;
    }
    public FunctionNode deleteNodeByIndex(int index) throws FunctionPointIndexOutOfBoundsException, IllegalStateException{
        /*
         * Удаляет элемент по индексу и возвращает ссылку на элемент
         */
        if (index > this.length - 1 || index < 0) {
            throw new FunctionPointIndexOutOfBoundsException();
        } else if (this.length < 3) {
            throw new IllegalStateException("Недостаточно точек для удаления, должно быть минимум 3");
        }
        FunctionNode ptr = this.head.getNext();
        for (int i = 0; i <= index; i++) {
            ptr = ptr.getNext();
        }
        ptr.getPrev().setNext(ptr.getNext());
        ptr.getNext().setPrev(ptr.getPrev());
        --length;
        return ptr;
    }
    // Разделение методов списка и методов для функции
    public double getLeftDomainBorder(){
        /*
         * Возвращает левую границу области определения
         */
        return this.head.getNext().getValue().getX();
    }

    public double getRightDomainBorder(){
        /*
         * Возвращает правую границу области определения
         */
        return this.head.getNext().getPrev().getValue().getX();
    }
    public double getFunctionValue(double x){
        /*
         * Возвращает значение функции в точке x
         */
        if(x > this.getRightDomainBorder() || x < this.getLeftDomainBorder())
            return Double.NaN;
        int i = 0;
        for(; i < this.length; ++i){
            if(x == this.getNodeByIndex(i).getValue().getX())
                return this.getNodeByIndex(i).getValue().getY();
            else if(x < this.getNodeByIndex(i).getValue().getX())
                break;
        }
        /*
           f(x) = kx + b
           k = (y2 - y1) / (x2 - x1)
           b = y1 - k
         */
        double k = (this.getNodeByIndex(i).getValue().getY() - this.getNodeByIndex(i + 1).getValue().getY()) / (this.getNodeByIndex(i).getValue().getX() - this.getNodeByIndex(i + 1).getValue().getX());
        double b = (this.getNodeByIndex(i).getValue().getY() - k * this.getNodeByIndex(i).getValue().getX());
        return (k * x + b);
    }
    public int getPointsCount(){
        return this.length;
    }
    public FunctionPoint_3 getPoint(int index){
        /*
         * Возвращает точку по индексу
         */
        try {
            return this.getNodeByIndex(index).getValue();
        } catch (FunctionPointIndexOutOfBoundsException e) {
            System.out.print("Точка с индексом " + index + " не найдена.");
            return null;
        }
    }
    public void setPoint(int index, FunctionPoint_3 point){
        /*
         * Заменяет точку по индексу
         */
        try {
            this.getNodeByIndex(index).setValue(point);
        } catch (FunctionPointIndexOutOfBoundsException e){
            System.out.print("Точка с индексом " + index + " не найдена.");
        }
    }
    public double getPointX(int index){
        /*
         * Возвращает значение x точки по индексу
         */
        try{
            return this.getNodeByIndex(index).getValue().getX();
        } catch (FunctionPointIndexOutOfBoundsException e) {
            System.out.print("Точка с индексом " + index + " не найдена.");
            return Double.NaN;
        }
    }
    public double getPointY(int index){
        /*
         * Возвращает значение y точки по индексу
         */
        try{
            return this.getNodeByIndex(index).getValue().getY();
        } catch (FunctionPointIndexOutOfBoundsException e) {
            System.out.print("Точка с индексом " + index + " не найдена.");
            return Double.NaN;
        }
    }
    public void setPointX(int index, double x){
        /*
         * Заменяет значение x точки по индексу
         */
        try {
            if (x < this.getNodeByIndex(index - 1).getValue().getX() || x > this.getNodeByIndex(index + 1).getValue().getX())
                return;
            this.getNodeByIndex(index).getValue().setX(x);
        }catch (InappropriateFunctionPointException e){
            System.out.print("Точка с индексом " + index + " не найдена.");
        }
    }
    public void setPointY(int index, double y){
        /*
         * Заменяет значение y точки по индексу
         */
        try {
            this.getNodeByIndex(index).getValue().setY(y);
        }catch (InappropriateFunctionPointException e){
            System.out.print("Точка с индексом " + index + " не найдена.");
        }
    }
    public void deletePoint(int index){
        /*
         * Удаляет точку по индексу
         */
        try {
            this.deleteNodeByIndex(index);
        } catch (FunctionPointIndexOutOfBoundsException e){
            System.out.print("Точка с индексом " + index + " не найдена.");
        }
    }
    public void addPoint(FunctionPoint_3 point){
        /*
         * Добавляет точку согласно значению х с сохранением упорядоченности списка
         */
        FunctionNode ptr = this.head.getNext();
        int i = 0;
        while(this.getNodeByIndex(i++).getValue().getX() < point.getX());
        this.addNodeByIndex(i - 1, point);
    }
}
