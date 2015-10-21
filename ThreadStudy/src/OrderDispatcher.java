
 
import java.util.ArrayList;
 
/**
 * Order���ؾ���ʵ����
 *
 */
public class OrderDispatcher {
 
    private String[] compIdArr = null; //�μӸ��ؾ����compId����
    private int[] dispatchCountArr = null; //���ط�������
 
    public OrderDispatcher() {
 
    }
 
    /**
     * ��ʼ��compId����͸��ط�������
     * @param scaleStaticList
     */
    public void init(ArrayList<ScaleStaticsValue> scaleStaticList) {
        if (!scaleStaticList.isEmpty()) {
            compIdArr = new String[scaleStaticList.size()];
            dispatchCountArr = new int[scaleStaticList.size()];
        }
 
        /**
         * ��̬���ؾ����㷨�ļ�˵��
         * ʵ�ֵ����⣺
         *      Ŀǰ��N����ԴScale1~ScaleN������N����Դ���ڴ���������ȵ�������ʱ����M������
         *      ��ΰ�M������ַ�����N����Դ�У�ʹ�÷ַ���֮����N����Դ������������Ǿ���ġ�
         *
         * ���ʶ���
         *      Scale-��Դ
         *      Order-����
         *      compId-ÿ����Դ��Ψһ��ʶ
         *
         * compId����-compIdArr
         *      ����ÿ��ScaleĿǰ�������Order�������٣���С��������Ӧ��compId��¼��������
         * 
         * ���ط�������-dispatchCountArr
         *      ����dispatchCountArr[i]������ֵ��ʾ���ǿ��Էַ���Order�ĸ�����
         *      �ַ���compId�ķ�Χ����compIdArr[0]��compIdArr[i]֮�䡣
         *      ���������3��Scale�����ǵ�compId�͵�ǰ��Order�����ֱ�Ϊ
         *          Scale1��1��Scale2��5��Scale3�� 12
         *      ��ô�����������ݿ��Թ���һ�����ط�������
         *          dispatchCountArr[0]=(5-1)*1=4       ��ʾ������Scale1���ٷ���4��Order
         *          dispatchCountArr[1]=(12-5)*2=14     ��ʾ������Scale1��Scale2��ƽ������14��Order
         *          dispatchCountArr[2]=�������ֵ      ��ʾ������Scale1~Scale3����ƽ�����������Order
         * 
         * ���ж��Order��������ҪΪÿ��������һ��compIdʱ��
         * 1.�ȴ�dispatchCountArr[0]��ʼ�����dispatchCountArr[0]��Ϊ0��˵�����԰��������ָ�ɸ�Scale1��
         *   ����dispatchCountArr[0]��ֵ��1��
         * 
         * 2.�������dispatchCountArr[0]�Ѿ�Ϊ0���������dispatchCountArr[1]��
         *   �������0��˵�������ٴ�Scale1��Scale2��ȡһ������ָ�ɣ���dispatchCountArr[1] mod 2����һ��0��1
         *   ��index����˼����Scale1��Scale2֮�����ƽ�����䣬ȡcompIdArr[index]��Ϊ�����compId��
         *   ͬʱdispatchCountArr[1]��1
         * 
         * 3.���dispatchCountArr[1]Ҳ����Ϊ0����ô������dispatchCountArr[2]������2�еĲ�����
         *   ��dispatchCountArr[2] mod 3����һ��0��2��index����˼����Scale1��Scale3֮�����ƽ��ָ�ɣ�
         *   ȡcompIdArr[index]��ΪcompId��ͬʱdispatchCountArr[2]��1
         * 
         * 4.�ظ�3�еĲ�����ֱ�����е�Order���Ѿ���������һ��compId
         */
 
        int size = scaleStaticList.size();
        for (int i = 0; i < size; i++) {
            compIdArr[i] = scaleStaticList.get(i).compId;
 
            if (i == size - 1) {
                //the last
                dispatchCountArr[i] = Integer.MAX_VALUE;
            } else {
                dispatchCountArr[i] =
                    scaleStaticList.get(i + 1).orderCnt
                        - scaleStaticList.get(i).orderCnt;
                dispatchCountArr[i] = dispatchCountArr[i] * (i + 1);
            }
        }
    }
 
    /**
     * ���ݸ��ؾ����㷨��ȡһ�������compId
     * @return
     */
    public String getDispatchedcompId() {
        String compId = null;
        if (dispatchCountArr == null) {
            return compId;
        }
 
        for (int i = 0; i < dispatchCountArr.length; i++) {
            if (dispatchCountArr[i] == 0) {
                //˵��compIdArr[0]~compIdArr[i]�Ѿ������꣬��Ҫ�����һ��
                continue;
            } else {
                //������compIdArr[0]~compIdArr[i]�ķ�Χ�ڻ�ȡһ��compId
                int index = 0;
                if (i != 0) {
                    index = dispatchCountArr[i] % (i + 1);
                }
                compId = compIdArr[index];
                dispatchCountArr[i]--;
                break;
            }
        }
        return compId;
    }
 
    public class ScaleStaticsValue {
        public ScaleStaticsValue() {
 
        }
        public String compId = null; //compId
        public int orderCnt = 0; //order�ĸ���
    }
}