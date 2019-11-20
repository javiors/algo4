import org.junit.Test;

import static org.junit.Assert.*;

public class NodeUtilTest {

    @Test
    public void generate() {
        Node target = NodeUtil.generate(100, false);
        System.out.println(NodeUtil.printNode(target));
        Node reversed = NodeUtil.reverse(target);
        System.out.println(NodeUtil.printNode(reversed));




    }

    @Test
    public void iterate(){
        Node target = NodeUtil.generate(100, true);
        NodeUtil.iterate(target, 3);
    }
}
